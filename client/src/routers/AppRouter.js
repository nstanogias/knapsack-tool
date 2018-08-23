import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import DashBoard from '../components/DashBoard';
import AddProblem from '../components/AddProblem';
import Solution from '../components/Solution';
import Task from '../components/Task';

const AppRouter = () => (
  <BrowserRouter>
    <div>
      <Switch>
        <Route path="/" component={DashBoard} exact={true} />
        <Route path="/add" component={AddProblem} exact={true} />
        <Route path="/solution/:id" component={Solution} exact={true} />
        <Route path="/task/:id" component={Task} exact={true} />
      </Switch>
    </div>
  </BrowserRouter>
);

export default AppRouter;