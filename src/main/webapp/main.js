Vue.component('product',{
    props: {
        premium:{
            type: Boolean,
            required:true
        }
    },
    template:`
        <div class="product row">
            
            <div class="product-image col-sm">
                <a :href="link"><img :src="image" class="img-thumbnail"></a>
                
            </div>

            <div class="product-info col-sm">
                <h1>{{ title }}</h1>
                <p v-if="onSale">On Sale!</p>
                <p>Shipping: {{ shipping }}</p>
                <ul>
                    <li v-for="detail in details">{{detail}}</li>
                </ul>
                <div v-for="(variant,index) in variants" 
                :key="variant.variantId"
                class="color-box col-sm"
                @mouseover="updateProduct(index)">
                    <div class="col-sm" :style="{backgroundColor:variant.variantColor}">
                        <p>{{variant.variantColor}}</p>
                    </div>  
                    <div class="col-sm">  
                        <p v-if="variant.variantQuantity > 5">In stock</p>
                        <p v-else-if="variant.variantQuantity <= 5 && variant.variantQuantity > 0">Almost sold out!</p>
                        <p v-else>Out of stock</p>
                        <button v-on:click="addToCart" 
                                :disabled="!variantInStock(index)"
                                :class="{disabledButton: !variant.variantQuantity>0}">
                                Add to cart</button>
                        <button v-if="variant.variantCart>0" v-on:click="removeFromCart">Remove from cart</button>
                        <div class="variant.variantCart">
                            <p>Cart ({{variant.variantCart}})</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    `,
    data(){return{
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
    }},
    methods: {
        addToCart() {
            this.variants[this.selectedVariant].variantCart += 1
            this.variants[this.selectedVariant].variantQuantity -=1
            this.$emit('add-to-cart',this.variants[this.selectedVariant].variantId)
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
        },
        shipping(){
            if(this.premium) return "Free"
            return "2,99"
        }
    }
})

var app = new Vue({
    el: '#app',
    data: {
        premium:false,
        cart:[]
    },
    methods:{
        addToCart(id){
            this.cart.push(id)
        }
    }
})
