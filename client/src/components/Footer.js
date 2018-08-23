import React from 'react';

export default () => {
  return (
    <footer id="main-footer" className="bg-dark text-white mt-5 p-5">
      <div className="container">
        <div className="row">
          <div className="col">
            <p className="lead text-center">
              Copyright &copy;
              <span id="year"></span>
              Nikolaos Stanogias
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
};