import React, { Component } from "react";

import "../Login/login.styles.scss";
import { Link } from "react-router-dom";
import { Input, AuthButton } from "../../components";
import { Form } from "react-bootstrap";

const ENTITY_TYPES = [
  {
    label: "Author",
    value: "AUTHOR"
  },
  {
    label: "Steering committee",
    value: "STEERING_COMMITTEE"
  },
  {
    label: "Reviewer",
    value: "REVIEWER"
  }
];

// one dumb component in which we pass props and actions
export default class Register extends Component {
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  state = {
    email: "",
    password: "",
    name: "",
    affiliation: "",
    webpage: "",
    entityType: ENTITY_TYPES[0].value
  };

  handleChange(value, name) {
    this.setState({ [name]: value });
  }

  handleSubmit(e) {
    const { register, setError } = this.props;
    const {
      email,
      password,
      name,
      affiliation,
      webpage,
      entityType
    } = this.state;
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!re.test(email)) {
      setError("Invalid email");
      return;
    }
    if (password.length < 6) {
      setError("Invalid password");
      return;
    }
    if (!name) {
      setError("Name field is required");
      return;
    }
    if (!affiliation) {
      setError("Affiliation field is required");
      return;
    }
    if (!webpage) {
      setError("Webpage field is required");
      return;
    }
    if (!entityType) {
      setError("Entity field is required");
      return;
    }
    register({ email, password, affiliation, webpage, entityType, name });
  }

  render() {
    const { isLoading, error } = this.props;
    const {
      email,
      password,
      name,
      affiliation,
      webpage,
      entityType
    } = this.state;
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
                      name="email"
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
                    <Input
                      name="name"
                      icon={<i className="fas fa-signature" />}
                      label="Name"
                      value={name}
                      onChange={e => this.handleChange(e.target.value, "name")}
                    />
                    <Input
                      name="affiliation"
                      icon={<i className="fas fa-users" />}
                      label="Affiliation"
                      value={affiliation}
                      onChange={e =>
                        this.handleChange(e.target.value, "affiliation")
                      }
                    />
                    <Input
                      name="webpage"
                      icon={<i className="fas fa-globe-europe" />}
                      label="Web page"
                      value={webpage}
                      onChange={e =>
                        this.handleChange(e.target.value, "webpage")
                      }
                    />
                    <Form.Control
                      as="select"
                      onChange={e =>
                        this.handleChange(e.target.value, "entityType")
                      }
                    >
                      {ENTITY_TYPES.map(item => (
                        <option value={item.value} key={item.value}>
                          {item.label}
                        </option>
                      ))}
                    </Form.Control>
                    {error && <div className="error">{error}</div>}
                    {/* <input type="submit" value="Submit" /> */}
                    <AuthButton onClick={this.handleSubmit}>submit</AuthButton>
                    {isLoading && (
                      <div className="loaderContainer">
                        <i className="fas fa-spinner fa-spin loader" />
                      </div>
                    )}
                    <div className="redirectAuthLink">
                      Log in <Link to="/login">here</Link>
                    </div>
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
