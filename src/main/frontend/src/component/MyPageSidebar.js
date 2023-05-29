import {NavLink, useLocation} from "react-router-dom";

import classes from './css/MyPageSidebar.module.css';
import SidebarLogo from './assert/images/hiyoko0305.png';
import MyRank from "./MyRank";

const MyPageSidebar = () => {
  const location = useLocation();

  return (
    <>
      <div className={`${classes['sidebar-wrap']}`}>
        <div className={`${classes['myinfo-wrap']}`}>
          <img src={SidebarLogo} alt="Sidebar Logo" width={100}/>
          <br/>
          <span>김찬희님</span>
          <h2>마이페이지</h2>
        </div>
        <div className={`${classes['myinfo-sidebar-wrap']}`}>
          <ul>
            <li><NavLink to={'/mypage/info'} className={`${location.pathname.includes('info') ? classes.isActive : undefined}`}>개인정보 관리</NavLink></li>
            <li><NavLink to={'/mypage/bankAccount/deposit'} className={`${location.pathname.includes('bank') ? classes.isActive : undefined}`}>나의 계좌관리</NavLink></li>
            <li><NavLink to={'/mypage/stage'} className={`${location.pathname.includes('stage') ? classes.isActive : undefined}`}>나의 스테이지</NavLink></li>
          </ul>
        </div>
        <MyRank pRank={'A'}/>
      </div>
    </>
  );
};

export default MyPageSidebar;