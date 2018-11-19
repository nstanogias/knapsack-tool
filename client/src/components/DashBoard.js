import React, {Component} from 'react';
import {connect} from 'react-redux';
import {getTasks} from '../actions/taskActions';
import {Link} from 'react-router-dom';

class DashBoard extends Component {

  componentWillMount() {
    this.props.getTasks();
  }

  render() {

    const {tasks} = this.props.tasks;

    let tableData = null;
    if(tasks.length > 0) {
      tableData = tasks.map(task => (
        <tr key={task.taskId}>
          <td>{<Link to={`/task/${task.taskId}`}>{task.taskId}</Link>}</td>
          <td>{task.status}</td>
          <td>{task.status === 'completed' ? <Link to={`/solution/${task.taskId}`}>solution</Link> : null}</td>
          <td>
            <a href="#" className="btn btn-secondary">
              <i className="fas fa-angle-double-right"></i> Details
            </a>
          </td>
        </tr>
      ))
    }

    return (
      <div>
        <section id="actions" className="py-4 mb-4 bg-light">
          <div className="container">
            <div className="row">
              <div className="col-md-3">
                <Link to="/addTask" className="btn btn-primary btn-block">
                  <i className="fas fa-plus"></i> Add Task
                </Link>
              </div>
            </div>
          </div>
        </section>

        <section id="tasks">
          <div className="container">
            <div className="row">
              <div className="col-md-9">
                <div className="card">
                  <div className="card-header">
                    <h4>Latest Tasks</h4>
                  </div>
                  <table className="table table-striped">
                    <thead className="thead-dark">
                    <tr>
                      <th>Id</th>
                      <th>Status</th>
                      <th>Solution</th>
                      <th></th>
                    </tr>
                    {tableData}
                    </thead>
                  </table>
                </div>
              </div>
              <div className="col-md-3">
                <div className="card text-center bg-primary text-white mb-3">
                  <div className="card-body">
                    <h3>Tasks</h3>
                    <h4 className="display-4">
                      <i className="fas fa-pencil-alt"></i> {tasks.length}
                    </h4>
                    {/*<a href="#" className="btn btn-outline-light btn-sm">View</a>*/}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    )
  }
}

const mapStateToProps = (state) => {
  return {
    tasks: state
  };
};

export default connect(mapStateToProps, {getTasks})(DashBoard);