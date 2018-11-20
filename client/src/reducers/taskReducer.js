const initialState = {
  tasks: []
};

export default (state = initialState, action) => {
  switch (action.type) {
    case 'GET_TASKS':
      return {
        ...state,
        tasks: action.tasks
      };
    default:
      return state;
  }
};