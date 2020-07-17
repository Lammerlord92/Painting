var product = 'Socks'
var app = new Vue({
    el: '#app',
    data: {
        product: 'Socks',
        branch:"Brand",
        image: './assets/vmSocks-green.jpeg',
        description: 'This is a pair of socks',
        link: 'https://vuetifyjs.com/en/getting-started/quick-start/',
        inventory: 10,
        onSale: "true",
        details: ["80% cotton", "20% polyester", "Gender-neutral"],
        variants: [
            {
                variantId: 2234,
                variantColor: "green",
                variantImage: './assets/vmSocks-green.jpeg'
            },
            {
                variantId: 2235,
                variantColor: "blue",
                variantImage: './assets/vmSocks-blue.jpeg'
            }
        ],
        cart: 0
    },
    methods: {
        addToCart() {
            this.cart += 1
            this.inventory -=1
        },
        removeFromCart() {
            this.cart -= 1
            this.inventory +=1
        },
        updateProduct(variantImage){
            this.image=variantImage
        }
    },
    computed:{
        title() {
            return this.brand+ this.name
        }
        
    }
})