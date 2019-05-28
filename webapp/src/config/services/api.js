// a library to wrap and simplify api calls
import apisauce from "apisauce";
import browserHistory from "../history/history";

// our "constructor"
// http://localhost:8080/ is the address of the spring server
const create = (baseURL = "http://localhost:9090/") => {
  const api = apisauce.create({
    // base URL is read from the "constructor"
    baseURL,
    // here are some default headers
    headers: {},
    // 10 second timeout...
    timeout: 10240,
    withCredentials: true
  });

  api.addResponseTransform(response => {
    if (response.status === 401) {
      //TODO ADD MOBX STORE AUTH
      browserHistory.push("/login");
    }
  });

  return {
    // a list of the API functions
    login: (email, password) =>
      api.post(`/api_login?email=${email}&password=${password}`),
    logout: () => api.get("/logout"),
    register: data => {
      console.log(data);
      return api.post("/register", data);
    },
    // getOffers: () => api.get("/offer"),
    // getCauses: () => api.get("/cause"),
    // getOwnOffers: () => api.get("/offer/getOwn"),
    // saveOffer: data => api.post("/offer", data),
    // getProposalsDonor: () => api.get("/proposal/getOwn"),
    // saveProposal: data => api.post("/proposal/create", data),
    // getCurrentUser: () => api.get("/user"),
    // declineProposal: proposalId => api.post(`/proposal/${proposalId}/deny`),
    // acceptProposal: (proposalId, payload) =>
    //   api.post(`/proposal/${proposalId}/accept`, payload),
    // getAcceptedProposals: () => api.get("/proposal/getAccepted")
    getRepositoriesByName: query =>
      api.get(`/search/repositories?q=${query}&sort=stars`)
  };
};

export default {
  create
};
