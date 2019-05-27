import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import Login from "../../module/Login/Login";
// the smart component that is linked to the store

@inject("store")
@observer
export default class LoginRoute extends Component {
  state = {};
  login = ({ email, password }) => {
    const {
      store: {
        auth: { login }
      }
    } = this.props;
    // console.log(email, password);
    login({ email, password });
  };
  render() {
    const {
      store: {
        auth: { isLoading, register, error }
      }
    } = this.props;
    return (
      <Login
        isLoading={isLoading}
        register={register}
        login={this.login}
        error={error}
      />
    );
  }
}
