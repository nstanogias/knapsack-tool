import React, { Component } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import {Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';


class Landing extends Component {

  constructor() {
    super();

    this.state = {
      modal: true
    };

    this.toggle = this.toggle.bind(this);
  }

  componentDidMount() {
    if (this.props.security.validToken) {
      this.props.history.push("/dashboard");
    }
  }

  toggle() {
    this.setState({
      modal: !this.state.modal
    });
  }

  render() {
    return (
      <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h1 className="display-3 mb-4">
                  Knapsack App
                </h1>
                <p className="lead">
                  Create your account to create knapsack problems
                </p>
                <hr />
                <Link className="btn btn-lg btn-primary mr-2" to="/register">
                  Sign Up
                </Link>
                <Link className="btn btn-lg btn-secondary mr-2" to="/login">
                  Login
                </Link>
              </div>
            </div>
          </div>
        </div>
        <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}>
          <ModalHeader toggle={this.toggle}>Admin Credentials</ModalHeader>
          <ModalBody>
            <div>
              <p>username: admin@gmail.com</p>
              <p>password: admin123</p>
            </div>
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={this.toggle}>OK</Button>
          </ModalFooter>
        </Modal>
      </div>
    );
  }
}

Landing.propTypes = {
  security: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  security: state.security
});

export default connect(mapStateToProps)(Landing);
