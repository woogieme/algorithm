export default {
    template:`
        <div>
            <button v-on:click="plus">+</button>
            <button v-on:click="minus">-</button>
            <button v-on:click="reset">reset</button>
        </div>
    `,
    data() {
        return {   
        }
    },
    methods: {
        plus() {
            this.$emit("plus");
        },
        minus() {
            this.$emit("minus");
        },
        reset() {
            this.$emit("reset");
        }
    },
    created(){},
}