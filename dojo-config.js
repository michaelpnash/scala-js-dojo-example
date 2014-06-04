  dojoConfig= {
    async: true, 
    packages: [
      {
        name: 'dgrid',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/js/dgrid'
      },
      {
        name: 'xstyle',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/js/xstyle'
      },
      {
        name: 'put-selector',
        location: location.pathname.replace(/\/[^/]+$/, '') + '/js/put-selector'
      }
    ]
  };
