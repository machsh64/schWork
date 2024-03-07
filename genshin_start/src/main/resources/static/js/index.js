function getMemberList (params) {
    return $axios({
        url: '/student/page',
        method: 'get',
        params
    })
}

function addAccount (params) {
    return $axios({
        url: '/alipay/pay',
        method: 'get',
        params
    })
}
