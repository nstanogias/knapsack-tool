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
      if(task.taskId === 8) {
        knapsack = task;
      }
    });

    // let solution = null;
    // if(knapsack) {
    //   console.log(knapsack.solution.items);
    //   solution = knapsack.solution.items.map((item) => <li key={item}>{item}</li>);
    // }

    return (
      <div className="text-center">
        <h1>Description of task with id {this.props.match.params.id} is</h1>
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