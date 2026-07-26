import React, { Component } from "react";

class App extends Component {

  constructor() {
    super();
    this.state = {
      count: 0,
      amount: "",
      currency: ""
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    alert("Hello! Member!");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (message) => {
    alert(message);
  };

  onPress = () => {
    alert("I was clicked");
  };

  handleAmount = (e) => {
    this.setState({ amount: e.target.value });
  };

  handleCurrency = (e) => {
    this.setState({ currency: e.target.value });
  };

  handleSubmit = (e) => {

    e.preventDefault();

    const euro = (parseFloat(this.state.amount) / 90).toFixed(2);

    alert(
      `Converting to Euro Amount is € ${euro}`
    );

  };

  render() {

    return (

      <div style={{ margin: "20px" }}>

        <h2>{this.state.count}</h2>

        <button onClick={this.handleIncrement}>
          Increment
        </button>

        <br /><br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br /><br />

        <button
          onClick={() => this.sayWelcome("Welcome")}
        >
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.onPress}>
          Click on me
        </button>

        <br /><br />

        <h1 style={{ color: "green" }}>
          Currency Convertor!!!
        </h1>

        <form onSubmit={this.handleSubmit}>

          <label>Amount:</label>

          <input
            type="number"
            value={this.state.amount}
            onChange={this.handleAmount}
          />

          <br /><br />

          <label>Currency:</label>

          <input
            type="text"
            value={this.state.currency}
            onChange={this.handleCurrency}
          />

          <br /><br />

          <button type="submit">
            Submit
          </button>

        </form>

      </div>

    );
  }
}

export default App;