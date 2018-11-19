import React, {Component} from 'react';
import {connect} from 'react-redux';
import {createTask} from "../../actions/taskActions";

class AddTask extends Component {
  constructor() {
    super();

    this.state = {
      val: 0,
      capacity: 0,
      values: [0],
      weights: [0],
      errors: {}
    };

    this.onSubmit = this.onSubmit.bind(this);
    this.addPair = this.addPair.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onChangeValues = (e, index) => {
    const val = e.target.value;
    this.setState(state => {
      const values = state.values.map((item, j) => {
        if (j === index) {
          return val;
        } else {
          return item;
        }
      });

      return {
        values,
      };
    });
  };

  onChangeWeights = (e, index) => {
    const val = e.target.value;
    this.setState(state => {
      const weights = state.weights.map((item, j) => {
        if (j === index) {
          return val;
        } else {
          return item;
        }
      });

      return {
        weights,
      };
    });
  };

  onChangeCapacity = (e) => {
    this.setState({ [e.target.name]: e.target.value })
  };

  addPair() {
    this.setState(state => {
      const values = [...state.values, state.val];
      const weights = [...state.weights, state.val];
      return {
        values,
        weights
      };
    });
  };

  removePair = (index) => {
    this.setState(state => {
      const values = state.values.filter((item, j) => index !== j);
      const weights = state.weights.filter((item, j) => index !== j);
      return {
        values,
        weights
      };
    });
  };

  onSubmit(e) {
    e.preventDefault();
    const newTask = {
      capacity: this.state.capacity,
      values: this.state.values,
      weights: this.state.weights,
    };
    this.props.createTask(newTask, this.props.history);
  };

  render() {

    const formRows = this.state.values.map((value, index) => (
        <div key={index} className="form-row">
          <div className="form-group col-md-6">
            <label>Value:</label>
            <input
              type="number"
              className="form-control"
              name="values"
              value={this.state.values[index]}
              onChange={(e) => this.onChangeValues(e, index)}
            />
          </div>
          <div className="form-group col-md-6">
            <label>Weight:</label>
            <div className="input-group">
              <input type="number"
                     className="form-control mr-1"
                     name="weights"
                     value={this.state.weights[index]}
                     onChange={(e)=>this.onChangeWeights(e, index)}
              />
              <button
                type="button"
                className="btn btn-success mr-1"
                onClick={this.addPair}
              >
                <span className="fas fa-plus"></span>
              </button>
              <button
                type="button"
                className="btn btn-danger"
                onClick={() => this.removePair(index)}
              >
                <span className="fas fa-minus"></span>
              </button>
            </div>
          </div>
        </div>
      ));

    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Task Form</h5>
              <form onSubmit={this.onSubmit}>
                <div className="form-row">
                  <div className="form-group col-md-8">
                    <label>Capacity:</label>
                    <input type="number"
                           className="form-control"
                           name="capacity"
                           value={this.state.capacity}
                           onChange={(e)=>this.onChangeCapacity(e)}
                    />
                  </div>
                </div>
                {formRows}
                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(mapStateToProps , { createTask })(AddTask);