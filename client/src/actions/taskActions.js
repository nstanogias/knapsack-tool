import axios from 'axios';
import {GET_ERRORS, GET_TASKS} from "./actionTypes";

const _getTasks = (tasks) => ({
  type: GET_TASKS,
  tasks
});

export const getTasks = () => {
  return (dispatch) => {
    return axios.get('api/knapsack/admin/tasks').then(result => {
      const tasks = [];

      result.data.forEach(task => {
        tasks.push(task);
      });

      dispatch(_getTasks(tasks));
    });
  };
};

export const createTask = (task, history) => async dispatch => {
  try {
    await axios.post("/api/knapsack/tasks", task);
    history.push("/dashboard");
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