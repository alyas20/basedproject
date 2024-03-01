const fs = require('fs');

// Load the master text from text.json
const masterText = require('../nodejs/text.json');

// Define the languages and their codes
const languages = {
  "en": "English",
  "bm": "Bahasa Malaysia",
  "ch": "Chinese"
};

// Iterate over each language
Object.keys(languages).forEach(languageCode => {
  const langText = {};
  // Iterate over each key in the masterText
  Object.keys(masterText).forEach(key => {
    // Split the key by '.' to create a hierarchical structure
    const keys = key.split('.');
    let currentObject = langText;
    // Build the hierarchical structure
    for (let i = 0; i < keys.length; i++) {
      const currentKey = keys[i];
      // If it's the last key, assign the translation
      if (i === keys.length - 1) {
        currentObject[currentKey] = masterText[key];
      } else {
        // If the object doesn't exist, create it
        currentObject[currentKey] = currentObject[currentKey] || {};
        // Move to the next level
        currentObject = currentObject[currentKey];
      }
    }
  });
  // Write the language-specific JSON file
  fs.writeFileSync(`${languageCode}.json`, JSON.stringify(langText, null, 2));
  console.log(`Language-specific JSON file generated for ${languages[languageCode]} (${languageCode}).`);
});
