import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import Login from "../../module/Login/Login";
// the smart component that is linked to the store

@inject("store")
@observer
export default class LoginRoute extends Component {
  state = {};
  render() {
    const {
      store: {
        auth: { isLoading, register }
      }
    } = this.props;
    return (
      <div
        onClick={() =>
          register({
            email: "alex@email.com",
            password: "password",
            affiliation: "sdfs",
            webpage: "sdfsd",
            entityType: "author",
            name: "Alex"
          })
        }
      >
        <Login />
        {isLoading && "...Loading"}
      </div>
    );
  }
}
