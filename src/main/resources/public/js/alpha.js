class Alpha extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        function: "intraday",
        symbol: "",
        jsonRes: {},
        interval: "",
      };
      this.handleChangeSelect = this.handleChangeSelect.bind(this);
      this.handleChangeInput = this.handleChangeInput.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
      this.handleChangeInputInterval = this.handleChangeInputInterval.bind(this);
    }
  
    handleChangeInput(event) {
      this.setState({ symbol: event.target.value });
    }
    handleChangeInputInterval(event) {
      this.setState({ interval: event.target.value });
    }
  
    handleChangeSelect(event) {
      this.setState({ function: event.target.value });
    }
  
    handleSubmit(event) {
      this.loadPostMsg();
      event.preventDefault();
    }
  
    loadPostMsg() {
      let url =
        "/stock?function=" + this.state.function + "&symbol=" + this.state.symbol;
      if (this.state.function == "intraday") {
        url += "&interval=" + this.state.interval;
      }
      fetch(url, { method: "GET" })
        .then((x) => x.json())
        .then((y) => {
          //Create a new visualizer object
          var _visualizer = new visualizer($("#resMSG"));
          //Visualize the demo json object
          _visualizer.visualize(y);
        });
    }
  
    render() {
      return (
        <div>
          <h1>AlphaVantage Info</h1>
          <form onSubmit={this.handleSubmit}>
            <label>Function:</label>
            <select
              value={this.state.function}
              onChange={this.handleChangeSelect}
            >
              <option value="intraday">Intraday</option>
              <option value="daily">Daily</option>
              <option value="weekly">Weekly</option>
              <option value="monthly">Monthly</option>
            </select>
            {this.state.function == "intraday" ? (
              <div>
                <label>Interval:</label>
                <input
                  required
                  type="text"
                  placeholder="Values are supported: 1min, 5min, 15min, 30min"
                  value={this.state.interval}
                  onChange={this.handleChangeInputInterval}
                ></input>
              </div>
            ) : (
              <div></div>
            )}
            <label>Symbol:</label>
            <input
              required
              type="text"
              placeholder="Example: IBM"
              value={this.state.symbol}
              onChange={this.handleChangeInput}
            ></input>
            <input type="submit" value="Submit" />
          </form>
        </div>
      );
    }
  }
  
  ReactDOM.render(<Alpha />, document.getElementById("root"));
