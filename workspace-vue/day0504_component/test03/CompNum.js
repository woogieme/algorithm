export default {
    template: `<h1>{{number}}</h1>`,
    props: ["cup"],
    data() {
        return {
            number: 0,
        }
    },
    created() {
        //엄마가 준 종이컵에 귀를 대고 있을게. 누가 hey하나
        this.cup.$on("hey", this.yes);
    },
    methods: {
        yes(tmp) {
            if (tmp == 0) {
                this.number = 0;
            }
            else {
                this.number += tmp;
            }
        }
    },
}