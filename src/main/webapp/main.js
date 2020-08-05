Vue.component('paint-form',{
    template:`
    <form class="review-form" @submit.prevent="onSubmit">
        <p v-if="errors.length">
            <b>Please correct the following error(s):</b>
            <ul>
                <li v-for="error in errors">{{error}}</li>
            </ul>
        </p>

        <p>
            <label for="name">Name:</label>
            <input id="name" v-model="name"></input>
        </p>
        <p>
            <label for="brand">Brand:</label>
            <input id="brand" v-model="brand" required></input>
        </p>
        <p>
            <label for="code">Code:</label>
            <input id="code" v-model="code"></input>
        </p>
        <p>
            <label for="notes">Notes:</label>
            <textarea id="notes" v-model="notes"></textarea>
        </p>
        <p>
            <label for="rating">Rating:</label>
            <select id="rating" v-model.number="rating">
                <option>5</option>
                <option>4</option>
                <option>3</option>
                <option>2</option>
                <option>1</option>
            </select>
        </p>
        <p>
            <input type="submit" value="Submit">
        </p>
    </form>
    `,
    data(){
        return{
            name: null,
            brand: null,
            code: null,
            notes: null,
            rating: null,
            errors: []
        }
    },methods:{
        onSubmit(){
            if(this.name && this.notes && this.rating){
                let paint={
                    name: this.name,
                    brand: this.brand,
                    code: this.code,
                    notes: this.notes,
                    rating: this.rating
                }
                this.$emit('paint-submitted',paint)
                this.name=null
                this.brand= null
                this.code =null
                this.notes= null
                this.rating= null
            } 
            else{
                if(!this.name) this.errors.push("Name required.")
                if(!this.notes) this.errors.push("Notes required.")
                if(!this.rating) this.errors.push("Rating required.")
            }  
        }
    }
})

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
                <div>
                    <h2>Paints/Review</h2>
                    <p v-if="!paints.length">There are no reviews yet.</p>
                    <ul>
                        <li v-for="paint in paints">
                            <p>{{paint.name}}</p>
                            <p>{{paint.notes}}</p>
                            <p>Rating: {{paint.rating}}/5</p>
                        </li>
                    </ul>
                </div>
                <paint-form @paint-submitted="addPainting"></paint-form>
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
        ],
        paints: []
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
        },
        addPainting(paint){
            this.paints.push(paint)
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
    },
    computed:{
        cartObjectNumber() {
            return this.cart.length
        }
    }
})
