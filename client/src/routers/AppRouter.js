import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Dashboard from '../components/DashBoard';
import Login from '../components/Auth/Login';
import Register from '../components/Auth/Register';
import Landing from '../components/Layout/Landing';
import AddTask from '../components/Task/AddTask';
import SolutionView from '../components/Task/SolutionView';
import TaskView from '../components/Task/TaskView';
import Header from '../components/Layout/Header';
import Footer from '../components/Layout/Footer';
import SecuredRoute from '../securityUtils/SecureRoute';

const AppRouter = () => (
  <BrowserRouter>
    <div className="App">
      <Header />
      {
        //Public Routes
      }

      <Route exact path="/" component={Landing} />
      <Route exact path="/register" component={Register} />
      <Route exact path="/login" component={Login} />

      {
        //Private Routes
      }
      <Switch>
        <SecuredRoute exact path="/dashboard" component={Dashboard} />
        <SecuredRoute exact path="/addTask" component={AddTask} />
        <SecuredRoute exact path="/solution/:id" component={SolutionView} />
        <SecuredRoute exact path="/task/:id" component={TaskView} />
      </Switch>
      <Footer/>
    </div>
  </BrowserRouter>
);

export default AppRouter;