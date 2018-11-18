import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import securityReducer from "./securityReducer";
import taskReducer from "./taskReducer";

export default combineReducers({
  errors: errorReducer,
  task: taskReducer,
  security: securityReducer
});
