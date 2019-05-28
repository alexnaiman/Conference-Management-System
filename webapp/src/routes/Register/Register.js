import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import Register from "../../module/Register/Register";
// the smart component that is linked to the store

@inject("store")
@observer
export default class RegisterRoute extends Component {
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
        auth: { isLoading, register, error, setError }
      }
    } = this.props;

    return (
      <Register
        isLoading={isLoading}
        register={register}
        login={this.login}
        error={error}
        setError={setError}
      />
    );
  }
}
