const API_BASE_URL="http://localhost:8080"

export const foodAPI={
    // retorna todas as comidas
    getAllFoods: async() =>{
        const response = await fetch(`${API_BASE_URL}/api/foods`);
        return response.json();
    },

    getFoodById: async(id) => {
        const response =await fetch(`${API_BASE_URL}/api/foods/${id}`);
        return response.json();
    },

    createFood: async(foodData) => {
        const response = await fetch(`${API_BASE_URL}/api/foods/`, {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json', 
            }, 
            body: JSON.stringify(foodData)
        });

        return response.json();
    }

};