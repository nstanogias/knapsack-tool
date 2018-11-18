import React, { Component } from 'react';
import { Provider } from 'react-redux';
import AppRouter from './routers/AppRouter';
import store from './store/store';
import setJWTToken from "./securityUtils/setJWTToken";
import { logout } from "./actions/securityActions";
import { SET_CURRENT_USER } from "./actions/actionTypes";
import jwt_decode from "jwt-decode";


const jwtToken = localStorage.jwtToken;

if (jwtToken) {
  setJWTToken(jwtToken);
  const decoded_jwtToken = jwt_decode(jwtToken);
  store.dispatch({
    type: SET_CURRENT_USER,
    payload: decoded_jwtToken
  });

  const currentTime = Date.now() / 1000;
  if (decoded_jwtToken.exp < currentTime) {
    store.dispatch(logout());
    window.location.href = "/";
  }
}

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <AppRouter/>
      </Provider>
    );
  }
}

export default App;
