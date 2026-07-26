import React, { Component } from "react";

function UserGreeting() {
  return (
    <div>
      <h1>Welcome back</h1>
      <h3>You can now book your flight tickets.</h3>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h1>Please sign up.</h1>
      <h3>Browse available flights.</h3>
    </div>
  );
}

function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  handleLogoutClick = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {

    const isLoggedIn = this.state.isLoggedIn;

    let button;

    if (isLoggedIn) {
      button = (
        <LogoutButton
          onClick={this.handleLogoutClick}
        />
      );
    } else {
      button = (
        <LoginButton
          onClick={this.handleLoginClick}
        />
      );
    }

    return (

      <div style={{ margin: "50px" }}>

        <Greeting isLoggedIn={isLoggedIn} />

        <br />

        {button}

      </div>

    );
  }
}

export default App;