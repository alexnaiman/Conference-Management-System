import React, { Component } from "react";

import "./login.styles.scss";
import { Input, AuthButton } from "../../components";

// one dumb component in which we pass props and actions
export default class Login extends Component {
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    console.log(document.cookie, "test");
  }
  state = {
    email: "",
    password: ""
  };

  handleChange(value, name) {
    this.setState({ [name]: value });
  }

  handleSubmit(e) {
    const { login } = this.props;
    const { email, password } = this.state;
    login({ email, password });
  }

  render() {
    const { isLoading, error } = this.props;
    const { email, password } = this.state;
    return (
      <div className="hero-image">
        <div className="container">
          <div className="row login-container">
            <div className="col-sm-6 half">
              <div className="card login-card">
                <div className="card-header">
                  <h2 className="card-title">
                    Welcome to <span>WowCms</span>
                  </h2>
                  <p className="card-subtitle">
                    Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut
                    odit aut fugit, sed quia consequuntur m
                  </p>
                </div>
                <div>
                  <div className="card-body">
                    <Input
                      name="emasfsdil"
                      icon={<i className="far fa-user" />}
                      label="Email"
                      value={email}
                      onChange={e => this.handleChange(e.target.value, "email")}
                    />
                    <Input
                      name="password"
                      icon={<i className="fas fa-lock" />}
                      label="Password"
                      value={password}
                      onChange={e =>
                        this.handleChange(e.target.value, "password")
                      }
                      type="password"
                    />
                    {error && <div className="error">{error}</div>}
                    {/* <input type="submit" value="Submit" /> */}
                    <AuthButton onClick={() => this.handleSubmit()}>
                      submit
                    </AuthButton>
                    {isLoading && (
                      <div className="loaderContainer">
                        <i className="fas fa-spinner fa-spin loader" />
                      </div>
                    )}
                  </div>
                </div>
              </div>
            </div>
            <div className="col-sm-6 half">
              <h1 className="loginTitle">Wow cms </h1>
              <div className="loginPresentation">
                Sed ut perspiciatis unde omnis iste natus error sit voluptatem
                accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
                quae ab illo inventore veritatis et quasi architecto beatae
                vitae dicta sunt explicabo.
              </div>
              <div className="loginSmallPresentation">
                Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit
                aut fugit, sed quia consequuntur m
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
