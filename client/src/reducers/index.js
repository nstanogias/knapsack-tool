import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import securityReducer from "./securityReducer";
import taskReducer from "./taskReducer";

export default combineReducers({
  errors: errorReducer,
  tasks: taskReducer,
  security: securityReducer
});
