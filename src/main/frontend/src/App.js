import {createBrowserRouter, RouterProvider} from "react-router-dom";

import RootLayout from "./page/root/Root";
import MyPageRootLayout from "./page/root/MyPageRoot";
import Home from "./page/Home";
import Login from "./page/account/Login";
import MyPage from "./page/account/MyPage";
import MyPageModify from "./page/account/MyPageModify";
import Board from "./page/Board";
import StageCreate from './page/stage/StageCreate';
import StagePartIn from './page/stage/StagePartIn';
import StageList from './page/stage/StageList';
import Account from "./page/account/Account";
import Logout from "./page/account/Logout";
import './App.css';
import Test from "./page/Test";

const App = () => {

  const router = createBrowserRouter([
    {
      path: '/',
      element: <RootLayout/>,
      children: [
        {
          index: true,
          element: <Home/>
        },
        {
          path: 'login',
          element: <Login/>
        },
        {
          path: 'logout',
          element: <Logout/>
        },
        {
          path: 'account',
          element: <Account/>
        },
        {
          path: 'mypage',
          element: <MyPageRootLayout/>,
          children: [
            {
              index: true,
              element: <MyPage/>
            },
            {
              path: ':uNo',
              element: <MyPageModify/>
            }
          ]
        },
        {
          path: 'board',
          element: <Board/>
        },
        {
          path: 'stagelist',
          element:<StageList/>
        },
        {
          path :'test/:pfID',
          element:<Test/>
        },

    {
         path: '/stageCreate',
         element: <StageCreate />
        },

    {
         path: '/stageAgree/:pfID',
         element: <StagePartIn />
     }

      ]
    },
  ]);


  return (
    <div className="App">
      <RouterProvider router={router}/>
    </div>
  );
};

export default App;
