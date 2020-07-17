var product = 'Socks'
var app = new Vue({
    el: '#app',
    data: {
        product: 'Socks',
        brand:"Vue Mastery",
        selectedVariant:0,
        description: 'This is a pair of socks',
        link: 'https://vuetifyjs.com/en/getting-started/quick-start/',
        onSale: "true",
        details: ["80% cotton", "20% polyester", "Gender-neutral"],
        variants: [
            {
                variantId: 2234,
                variantColor: "green",
                variantImage: './assets/vmSocks-green.jpeg',
                variantQuantity: 10,
                variantCart:0
            },
            {
                variantId: 2235,
                variantColor: "blue",
                variantImage: './assets/vmSocks-blue.jpeg',
                variantQuantity: 0,
                variantCart:0
            }
        ]
    },
    methods: {
        addToCart() {
            this.variants[this.selectedVariant].variantCart += 1
            this.variants[this.selectedVariant].variantQuantity -=1
        },
        removeFromCart() {
            this.variants[this.selectedVariant].variantCart -= 1
            this.variants[this.selectedVariant].variantQuantity +=1
        },
        updateProduct(index){
            this.selectedVariant=index
            console.log(this.selectedVariant)
        },
        variantInStock(index){
            return this.variants[index].variantQuantity>0
        }
    },
    computed:{
        title() {
            return this.brand+' '+ this.product
        },
        image() {
            return this.variants[this.selectedVariant].variantImage
        }
    }
})