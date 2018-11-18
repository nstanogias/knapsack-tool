import React, {Component} from 'react';

class Solution extends Component {

  render() {
    return (
      <h1>This is the solution for task id {this.props.match.params.id}</h1>
    )
  }
}

export default Solution;
