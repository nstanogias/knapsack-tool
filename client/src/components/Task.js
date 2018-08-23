import React, {Component} from 'react';

class Task extends Component {

  render() {
    return (
      <h1>This is the description of task with id {this.props.match.params.id}</h1>
    )
  }
}

export default Task;