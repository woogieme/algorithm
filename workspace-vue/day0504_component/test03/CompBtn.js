export default {
    template: `
    <div>
    <button v-on:click="send(+1)">+</button>
    <button v-on:click="send(-1)">-</button>
    <button v-on:click="send(0)">reset</button>
    </div>
    `,
    props:["cup"],
    data() {
        return {
            
        }
    },
    methods: {
        send(tmp) {
            // this.$emit('send-num', tmp ); //+1, -1,0
            this.cup.$emit("hey", tmp);
        }
    },
};