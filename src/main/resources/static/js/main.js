
getProducts = () =>{
    return fetch("/api/products")
        .then(response => response.json());
}

createProductHtmlEl = (productData) =>{
    const template  = `
        <div>
        <img src="https://picsum.photos/200/300?grayscale">
            <h4>${productData.name}</h4>
            <span>${productData.description}</span>
            <span>${productData.price}</span>
            <button data-id="${productData.id}">Add to cart</button>
        </div>
        `;
    const newEl = document.createElement("li");
    newEl.innerHTML = template.trim();
    return newEl;
}
document.addEventListener("DOMContentLoaded", () =>{
    console.log("it works");
    const productList= document.querySelector("#productList");
    getProducts()
        .then(products => products.map(createProductHtmlEl))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productList.appendChild(htmlEl))
            });
    });

