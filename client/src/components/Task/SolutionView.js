import React, {Component} from 'react';
import {connect} from 'react-redux';

class Solution extends Component {

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

    let solution = null;
    if(knapsack) {
      solution = knapsack.solution.items.map((item) => <li key={item} className="font-weight-bold h3">{`Item ${item}`}</li>);
    }

    return (
      <div className="text-center">
        <h1>Selected items for task id {this.props.match.params.id} are</h1>
        { solution && <ul className="list-unstyled">{solution}</ul> }
      </div>
    )
  }
}

const mapStateToProps = (state) => {
  return {
    tasks: state.tasks
  };
};

export default connect(mapStateToProps, null)(Solution);
