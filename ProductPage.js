import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import productService from "../services/productService";

function ProductPage() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    productService.getProductById(id).then(setProduct);
  }, [id]);

  if (!product) return <p>Loading...</p>;

  return (
    <div className="container text-center">
      <img src={product.imageUrl} alt={product.name} width="300" />
      <h2>{product.name}</h2>
      <p>{product.description}</p>
      <h4>${product.price}</h4>
    </div>
  );
}

export default ProductPage;
