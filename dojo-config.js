  dojoConfig= {
    async: true, 
    packages: [
      {
        name: 'dgrid',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/../../dgrid'
      },
      {
        name: 'xstyle',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/../../xstyle'
      },
      {
        name: 'put-selector',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/../../put-selector'
      }
    ]
  };
