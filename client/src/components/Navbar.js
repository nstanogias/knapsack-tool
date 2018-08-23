import React from 'react';

export default () => {
  return (
    <nav className="navbar navbar-expand-sm navbar-dark bg-dark p-0">
      <div className="container">
        <a href="#" className="navbar-brand">Knapsack</a>
        <button className="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarCollapse">
          <ul className="navbar-nav">
            <li className="nav-item px-2">
              <a href="#" className="nav-link active">Dashboard</a>
            </li>
            <li className="nav-item px-2">
              <a href="#" className="nav-link">Tasks</a>
            </li>
            <li className="nav-item px-2">
              <a href="#" className="nav-link">Users</a>
            </li>
          </ul>

          <ul className="navbar-nav ml-auto">
            <li className="nav-item dropdown mr-3">
              <a href="#" className="nav-link dropdown-toggle" data-toggle="dropdown">
                <i className="fas fa-user"></i> Welcome Admin
              </a>
              <div className="dropdown-menu">
                <a href="#" className="dropdown-item">
                  <i className="fas fa-user-circle"></i> Profile
                </a>
                <a href="#" className="dropdown-item">
                  <i className="fas fa-cog"></i> Settings
                </a>
              </div>
            </li>
            <li className="nav-item">
              <a href="#" className="nav-link">
                <i className="fas fa-user-times"></i> Logout
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}