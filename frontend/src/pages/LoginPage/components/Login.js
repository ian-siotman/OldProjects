import React from "react";
import {Map} from 'immutable';

const Login = ({inputId,inputPass,user,onChangeInput,onLogin}) => {
    const handleClickEnter = (e) => {
        if(e.charCode === 13){
            
            onLogin()
        }
    }
        return (
            <form className="AuthInfo" action="" method="post">
                <div className="form-group">
                <input value={inputId} onChange={e => onChangeInput(e, 'inputId')} type="text" className="form-control form-control-user" name="username" placeholder="사번" />
                </div>
                <div className="form-group">
                <input value={inputPass} onChange={e => onChangeInput(e, 'inputPass')} onKeyPress={handleClickEnter} type="password" className="form-control form-control-user" name="password" placeholder="비밀번호" />
                </div>
                <div className="form-group">
                <div className="custom-control custom-checkbox small">
                    <input type="checkbox" className="custom-control-input" id="customCheck" />
                    <label className="custom-control-label" htmlFor="customCheck">Remember Me</label>
                </div>
                </div>
                <input type="button" onClick={onLogin} className="btn btn-darkblue btn-user btn-block" value="LOGIN" />
            </form>
        );    
}   
Login.defaultProps= {
    inputId:'',
    inputPass:'',
    user: Map({
        id:'0',
        pass:'1'
    }),
}

export default Login;