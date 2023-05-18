import classes from './css/Footer.module.css';
import logo from './assert/images/logo0306.png';
/*=======
import logo from './assert/images/logo0301.png';
>>>>>>> feature/hyunji*/

const Footer = () => {

  return (
    <footer>
      <div className={`${classes['logo-wrap']}`}>
        <img src={logo} alt="logo" width={"150"} height={"70"}/>
      </div>
      <div className={`${classes['member-wrap']}`}>
        <p>팀장: 민재홍</p>
        <p>부팀장: 김찬희</p>
        <p>팀원: 권오수, 길현지, 김지연, 이유진, 이현지</p>
      </div>
    </footer>
  );
};

export default Footer;