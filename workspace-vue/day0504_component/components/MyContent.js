export default {
    template: ` 
        <h3>여기는 MyContent의 영역입니다.{{용돈}}</h3>
        
    `,
    //부모가 자식한테 값을줄때 props로 받는다
    props: ['용돈'],
    
}

//부모 컴포넌트가 자식 컴포넌트한테 값을 주고싶으면
//태그에게 용돈 땡떙해서 데이터 보냄
//그럼 자식은 props로 받아쓰면되더라

//자식 컴포넌트가 부모 컴포넌트한테 값을 주고싶으면