document.addEventListener("DOMContentLoaded", function() {
    // Fetch data from the API endpoint
    fetch('http://localhost:8081/api/LearnJava/fetchAll')
        .then(response => response.json())
        .then(data => {
            // Find the .sortable-list element
            const sortableList = document.querySelector('.selectRiderForm .sortable-list');

            // Create an object to categorize topics
            const categories = {};

            // Categorize topics by their category
            data.forEach(topic => {
                if (!categories[topic.category]) {
                    categories[topic.category] = [];
                }
                categories[topic.category].push({
                                    name: topic.name,
                                    url: topic.topicUrl // Assuming 'url' is the key in the API response
                                });
            });

            // Clear existing list items
            sortableList.innerHTML = '';

            // Loop through categories and create list items
            Object.keys(categories).forEach(category => {
                // Create a new <li> element
                const li = document.createElement('li');
                li.classList.add('item');

                // Create a new <div> element
                const div = document.createElement('div');
                div.classList.add('details');

                // Create and append the <h3> element for the category
                const h3 = document.createElement('h3');
                h3.textContent = category;
                div.appendChild(h3);

               // Create and append <p> elements for each topic
                               categories[category].forEach(topic => {
                                   const p = document.createElement('p');
                                   // Create a link with topicName and topicUrl
                                   const a = document.createElement('a');
                                   a.textContent = topic.name; // Use topicName for link text
                                   a.href = topic.url; // Use topicUrl for link
                                   a.target = "_top";
                                   a.style.textDecoration = "none";
                                   // Append the link to the paragraph
                                   p.appendChild(a);
                                   div.appendChild(p);
                               });


                // Append the div to the li and the li to the list
                li.appendChild(div);
                sortableList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});