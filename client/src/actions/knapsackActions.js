import axios from 'axios';

const _getTasks = (tasks) => ({
  type: 'GET_TASKS',
  tasks
});

export const getTasks = () => {
  return (dispatch) => {
    return axios.get('knapsack/admin/tasks').then(result => {
      const tasks = [];

      result.data.forEach(task => {
        tasks.push(task);
      });

      dispatch(_getTasks(tasks));
    });
  };
};