import React, { useEffect, useState } from "react";
import ProductCard from "../components/ProductCard";
import productService from "../services/productService";

function HomePage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    productService.getAllProducts().then((data) => setProducts(data));
  }, []);

  return (
    <div className="d-flex flex-wrap justify-content-center">
      {products.map((p) => <ProductCard key={p.id} product={p} />)}
    </div>
  );
}

export default HomePage;
