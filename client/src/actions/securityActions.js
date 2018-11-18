import axios from "axios";
import { GET_ERRORS, SET_CURRENT_USER } from "./actionTypes";
import setJWTToken from "../securityUtils/setJWTToken";
import jwt_decode from "jwt-decode";

export const createNewUser = (newUser, history) => async dispatch => {
  try {
    await axios.post("api/auth/register", newUser);
    history.push("/login");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const login = LoginRequest => async dispatch => {
  try {
    // post => Login Request
    const res = await axios.post("/api/auth/login", LoginRequest);
    // extract token from res.data
    const { accessToken } = res.data;
    // store the token in the localStorage
    localStorage.setItem("jwtToken", accessToken);
    // set our token in header ***
    setJWTToken(accessToken);
    // decode token on React
    const decoded = jwt_decode(accessToken);

    console.log("decoded is ", decoded);
    // dispatch to our securityReducer
    dispatch({
      type: SET_CURRENT_USER,
      payload: decoded
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const logout = () => dispatch => {
  localStorage.removeItem("jwtToken");
  setJWTToken(false);
  dispatch({
    type: SET_CURRENT_USER,
    payload: {}
  });
};
