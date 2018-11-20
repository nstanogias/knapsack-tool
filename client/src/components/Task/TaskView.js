import React, {Component} from 'react';
import {connect} from "react-redux";

class TaskView extends Component {

  constructor() {
    super();
  }

  render() {

    const {tasks} = this.props.tasks;

    let knapsack = null;
    tasks.forEach(task => {
      if(task.taskId == this.props.match.params.id) {
        knapsack = task;
      }
    });

    let values = null, weights=null, capacity=null;
    if(knapsack) {
      capacity = knapsack.problem.capacity;
      values = knapsack.problem.values.map((item) => <li key={item} className="list-inline-item font-weight-bold h3">{item}</li>);
      weights = knapsack.problem.weights.map((item) => <li key={item} className="list-inline-item font-weight-bold h3">{item}</li>);
    }

    return (
      <div className="text-center">
        <h1>Description of task with id {this.props.match.params.id} is</h1>
        { capacity &&
        <div className="d-inline-flex pt-2">
          <p className="font-weight-bold h3 mr-2">Capacity:</p>
          <p className="font-weight-bold h3">{capacity}</p>
        </div>
        }
        <div>
        </div>
        { values &&
        <div className="d-inline-flex pt-2">
          <p className="font-weight-bold h3 mr-2">Values:</p>
          <ul className="list-unstyled list-inline">{values}</ul>
        </div>
        }
        <div>
        </div>
        { weights &&
        <div className="d-inline-flex">
          <p className="font-weight-bold h3 mr-2">Weights:</p>
          <ul className="list-unstyled list-inline">{weights}</ul>
        </div>
        }
      </div>
    )
  }
}

const mapStateToProps = (state) => {
  return {
    tasks: state.tasks
  };
};

export default connect(mapStateToProps, null)(TaskView) ;