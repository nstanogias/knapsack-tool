import { createStore, applyMiddleware } from "redux";
import knapsack from '../reducers/knapsack';
import thunk from 'redux-thunk';

export default () => {
  return createStore(knapsack, applyMiddleware(thunk));
};