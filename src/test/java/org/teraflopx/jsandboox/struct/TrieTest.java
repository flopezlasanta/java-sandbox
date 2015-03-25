package org.teraflopx.jsandboox.struct;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class TrieTest {

	@Test
	public void test() {
		Collection<String> words = Arrays.asList("by", "bye", "bob", "ball");
		Collection<String> extras = Arrays.asList("ba", "byb", "vye");

		// validate trie
		Optional<Trie> optionalTrie = Trie.build(words);
		assertNotNull(optionalTrie);
		assertTrue(optionalTrie.isPresent());

		// validate root
		Trie root = optionalTrie.get();
		Optional<Character> optionalKey = root.getKey();
		assertNotNull(optionalKey);
		assertFalse(optionalKey.isPresent()); // root has no key
		assertNotNull(root.getChildren()); // root has children
		assertFalse(root.isLeaf()); // root is no leaf cause has children
		assertFalse(root.isWord()); // root is no word cause has no key

		// validate words and extras
		List<String> wordsAndExtras = new ArrayList<String>();
		wordsAndExtras.addAll(words);
		wordsAndExtras.addAll(extras);

		for (String word : wordsAndExtras) {
			Optional<Trie> optionalChild = root.find(word);
			assertNotNull(optionalChild);

			if (optionalChild.isPresent()) {
				System.out.println("hit:" + word + ":" + optionalChild.get());
			} else {
				System.out.println("miss:" + word);
			}
		}
	}

}
