//하나의 컴포넌트를 하나의 파일로 통으로 작성하기.
export default {
    // instance  에서 el: "#app" 이었던 부분 대신 template임.
    //template 가 태그 2개이상될때 하나의 블럭에 묶여있다는것을 명시를해줘야 작동이됨
    template: `
        <div>
        
        <h1>여기가 우리 사이트 헤더 부분 입니다.</h1>
        <input type="number" v-model="amount">
        <button v-on:click="mom">엄마!!!!! 나도!!!</button>
        </div>
    `,
    //date:{}, 이렇게 쓰고 싶어? 응 컴포넌트는 안돼~ 아래처럼 함수형태로만 가능~

    data() {
        //template에 보여줄 데이터 있으면 여기 설정.
        //v-bind,v-text,v-html은 단방향 데이터 vuejs가 가지고있는 데이터를 일방향으로 보내는것,v-model은 양방향으로 vue쪽에서 수정하면 실시간으로 변경, 다른방향에서 수정하면 vue쪽에서 수정하는 형식
        return {
            
        }
    },
    methods: {
        mom() {
            //엄마라는 이름의 이벤트 발생시키기
            this.$emit("mother",this.amount); //this.emt('이벤트이름',보낼데이터)
        }
    },
    created() { },

}