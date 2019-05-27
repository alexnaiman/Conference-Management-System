import { types, flow } from "mobx-state-tree";

import { User } from "../models";
import getApi from "../../config/services/apiProvider";

// Here we will add call our api service for requests *just like sagas/thunks*

const api = getApi();

const authStore = types
  .model("Auth", {
    error: "",
    isLoading: types.optional(types.boolean, false),
    userData: types.optional(User, {})
  })
  .views(self => ({
    get isLoggedIn() {
      return !!self.userData.email;
    }
  }))
  .actions(self => ({
    setLoading: value => {
      self.isLoading = value;
    },
    setError: (code, message) => {
      self.error = message.split(".")[0];
      self.setLoading(false);
    },
    setUser: user => {
      console.log(user);
      self.userData = User.create({
        email: user.email,
        name: user.displayName,
        image: user.photoURL
      });
      self.setLoading(false);
    },
    // helper function used to simulate login delay
    setToken: token => (self.token = token),
    // function that simulates a backend request with delay
    login: flow(function* login({ email, password }) {
      self.setLoading(true);
      const result = yield api.login(email, password);
      if (result.ok) {
        self.setUser(result.data);
      } else {
        self.setError(result.data);
      }
      self.setLoading(false);
    }),
    logout: flow(function* logout() {
      self.setLoading(true);
      const result = yield api.logout();
      if (result.ok) {
        self.setUser({});
      } else {
        self.setError(result.data);
      }
      self.setLoading(false);
    }),
    register: flow(function* register(data) {
      self.setLoading(true);
      const result = yield api.register(data);
      if (result.ok) {
        self.login(data);
      } else {
        self.setError(result.data);
      }
      self.setLoading(false);
    })
  }));

export default authStore;
