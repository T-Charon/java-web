
const TokenKey = 'Authorization'
//获取token
export function getToken() {
    return  localStorage.getItem(TokenKey);
}